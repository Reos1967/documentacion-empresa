// src/components/LayoutDashboard.jsx
import { Link, Outlet } from 'react-router-dom';
import { useContext } from 'react';
import { UsuarioContext } from '../context/UsuarioContext';

const LayoutDashboard = () => {
  const { usuario, logout } = useContext(UsuarioContext);

  return (
    <div className="flex min-h-screen">
      {/* Menú lateral */}
      <aside className="w-64 bg-gray-100 p-4 shadow">
        <h2 className="text-lg font-bold mb-4">Menú</h2>
        <ul className="space-y-2">
          <li><Link to="/dashboard" className="text-blue-700 hover:underline">Inicio</Link></li>
          <li><Link to="/manuales" className="text-blue-700 hover:underline">Manuales</Link></li>
          <li><Link to="/notificaciones" className="text-blue-700 hover:underline">Notificaciones</Link></li>
          <li><Link to="/calendario" className="text-blue-700 hover:underline">Calendario</Link></li>
          <li><Link to="/tareas" className="text-blue-700 hover:underline">Tareas</Link></li>
          {usuario.rol === 'admin' && (
            <li><Link to="/usuarios" className="text-blue-700 hover:underline">Gestionar usuarios</Link></li>
          )}
          <li>
            <button onClick={logout} className="text-red-500 hover:underline">Cerrar sesión</button>
          </li>
        </ul>
      </aside>

      {/* Contenido principal */}
      <main className="flex-1 p-6 bg-white">
        <Outlet />
      </main>
    </div>
  );
};

export default LayoutDashboard;

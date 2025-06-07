import React, { useContext } from 'react';
import { UsuarioContext } from '../context/UsuarioContext';
import TareaResumen from './TareaResumen';
import NotificacionesResumen from './NotificacionesResumen';
import { Link } from 'react-router-dom';

const Dashboard = () => {
  const { usuario, logout } = useContext(UsuarioContext);

  return (
  <div className="max-w-3xl mx-auto mt-20 text-center">
    <h1 className="text-2xl font-bold mb-2">Hola, {usuario.nombre}</h1>
    <p className="mb-4">Rol: <strong>{usuario.rol}</strong></p>

    {/* Aquí va el resumen de tareas y notificaciones */}
    <div className="grid grid-cols-1 md:grid-cols-2 gap-6 mb-6 text-left">
      <TareaResumen />
      <NotificacionesResumen />
    </div>

    {usuario.rol === 'admin' && (
  <div className="p-4 bg-blue-50 rounded shadow">
    <h2 className="text-lg font-semibold">Panel del Administrador</h2>
    <ul className="mt-2 text-left list-disc list-inside space-y-1">
      <li>
        <Link to="/usuarios" className="text-blue-700 hover:underline">Gestionar usuarios</Link>
      </li>
      <li>
        <Link to="/notificaciones" className="text-blue-700 hover:underline">Ver notificaciones</Link>
      </li>
      <li>
        <Link to="/manuales" className="text-blue-700 hover:underline">Subir manuales</Link>
      </li>
    </ul>
  </div>
)}


      {usuario.rol === 'asesor' && (
        <div className="p-4 bg-green-50 rounded shadow">
          <h2 className="text-lg font-semibold">Panel del Asesor</h2>
          <p>Accede a manuales, tareas y noticias asignadas.</p>
        </div>
      )}

      <button
        className="mt-6 bg-red-600 text-white px-4 py-2 rounded"
        onClick={logout}
      >
        Cerrar sesión
      </button>
    </div>
  );
};

export default Dashboard;
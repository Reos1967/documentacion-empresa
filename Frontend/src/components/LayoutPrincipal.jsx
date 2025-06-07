// src/components/LayoutPrincipal.jsx
import React from 'react';
import { Link, Outlet } from 'react-router-dom';

const LayoutPrincipal = () => {
  return (
    <div className="flex h-screen">
      {/* Menú lateral */}
      <aside className="w-64 bg-gray-800 text-white p-4">
        <h2 className="text-2xl font-bold mb-6">Mi Empresa</h2>
        <nav className="space-y-4">
          <Link to="/manuales" className="block hover:text-blue-300">📚 Manuales</Link>
          <Link to="/tareas" className="block hover:text-blue-300">📝 Tareas</Link>
          <Link to="/calendario" className="block hover:text-blue-300">📅 Calendario</Link>
          <Link to="/noticias" className="block hover:text-blue-300">📰 Noticias</Link>
          <Link to="/diccionario" className="block hover:text-blue-300">📖 Diccionario</Link>
        </nav>
      </aside>

      {/* Contenedor derecho */}
      <div className="flex-1 flex flex-col">
        {/* Encabezado con buscador */}
        <header className="bg-white shadow p-4 flex justify-between items-center">
          <h1 className="text-xl font-semibold">Panel de documentación</h1>
          <input
            type="text"
            placeholder="Buscar..."
            className="border rounded px-3 py-1 w-64"
          />
        </header>

        {/* Área de contenido */}
        <main className="p-6 bg-gray-100 flex-1 overflow-auto">
          <Outlet />
        </main>
      </div>
    </div>
  );
};

export default LayoutPrincipal;
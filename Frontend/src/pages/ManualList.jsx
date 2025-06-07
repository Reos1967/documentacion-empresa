import React, { useEffect, useState, useContext } from 'react';
import { UsuarioContext } from '../context/UsuarioContext';

const ManualList = () => {
  const { usuario } = useContext(UsuarioContext);
  const [manuales, setManuales] = useState([]);
  const [filtro, setFiltro] = useState('');

  useEffect(() => {
    fetch('http://localhost:8080/api/manuales')
      .then(res => res.json())
      .then(data => setManuales(data))
      .catch(err => console.error('Error cargando manuales:', err));
  }, []);

  const eliminarManual = async (id) => {
    await fetch(`http://localhost:8080/api/manuales/${id}`, { method: 'DELETE' });
    setManuales(manuales.filter(m => m.idManual !== id));
  };

  return (
    <div className="max-w-4xl mx-auto mt-10">
      <h2 className="text-2xl font-bold mb-4">Manuales disponibles</h2>

      {usuario.rol === 'admin' && (
        <a
          href="/crear-manual"
          className="bg-blue-500 text-white px-4 py-2 rounded mb-6 inline-block"
        >
          Crear nuevo manual
        </a>
      )}

      <input
        type="text"
        placeholder="Buscar por título..."
        value={filtro}
        onChange={(e) => setFiltro(e.target.value.toLowerCase())}
        className="border p-2 mb-4 w-full"
      />

      {manuales.length === 0 ? (
        <p>No hay manuales registrados aún.</p>
      ) : (
        <ul className="space-y-4">
          {manuales
            .filter((manual) =>
              manual.titulo.toLowerCase().includes(filtro)
            )
            .map((manual) => (
              <li
                key={manual.idManual}
                className="border p-4 rounded shadow-sm"
              >
                <h3 className="text-lg font-semibold">{manual.titulo}</h3>
                <p>{manual.descripcion}</p>
                <p className="text-sm text-gray-500">
                  Creado el: {new Date(manual.fechaCreacion).toLocaleDateString()}
                </p>

                {usuario.rol === 'admin' && (
                  <div className="flex gap-2 mt-2">
                <button
                  onClick={() => eliminarManual(manual.idManual)}
                  className="bg-red-600 text-white px-3 py-1 rounded"
                >
                Eliminar
                </button>
                <a
                  href={`/manuales/editar/${manual.idManual}`}
                  className="bg-yellow-500 text-white px-3 py-1 rounded"
                >
                Editar
                </a>
                </div>
              )}
              </li>
            ))}
        </ul>
      )}
    </div>
  );
};

export default ManualList;

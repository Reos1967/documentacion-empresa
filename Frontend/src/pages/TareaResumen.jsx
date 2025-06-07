import React, { useEffect, useState } from 'react';

const TareaResumen = () => {
  const [tareas, setTareas] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/api/tareas')
      .then(res => res.json())
      .then(data => setTareas(data))
      .catch(err => console.error('Error al cargar tareas', err));
  }, []);

  const actualizarEstado = async (idTarea, nuevoEstado) => {
    try {
      await fetch(`http://localhost:8080/api/tareas/${idTarea}`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ estado: nuevoEstado })
      });

      setTareas(tareas.map(t =>
        t.idTarea === idTarea ? { ...t, estado: nuevoEstado } : t
      ));
    } catch (err) {
      console.error('Error actualizando tarea', err);
    }
  };

  const actualizarProgreso = async (idTarea, nuevoProgreso) => {
    try {
      await fetch(`http://localhost:8080/api/tareas/${idTarea}`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ progreso: nuevoProgreso })
      });

      setTareas(tareas.map(t =>
        t.idTarea === idTarea ? { ...t, progreso: nuevoProgreso } : t
      ));
    } catch (err) {
      console.error('Error actualizando progreso', err);
    }
  };

  return (
    <div className="mb-6">
      <h3 className="text-xl font-bold mb-4">Resumen de Tareas</h3>
      {tareas.length === 0 ? (
        <p className="text-gray-600">No hay tareas registradas.</p>
      ) : (
        <ul className="space-y-4">
          {tareas.slice(0, 5).map((tarea) => (
            <li
              key={tarea.idTarea}
              className={`border p-4 rounded ${
                tarea.estado === 'completado'
                  ? 'bg-green-100'
                  : tarea.estado === 'en progreso'
                  ? 'bg-yellow-100'
                  : 'bg-red-100'
              }`}
            >
              <div className="flex justify-between items-center mb-2">
                <div className="flex items-center gap-2">
                  <input
                    type="checkbox"
                    checked={tarea.estado === 'completado'}
                    onChange={(e) =>
                      actualizarEstado(
                        tarea.idTarea,
                        e.target.checked ? 'completado' : 'pendiente'
                      )
                    }
                  />
                  <strong>{tarea.descripcion}</strong>
                </div>
                <span className="text-sm text-gray-700">
                  Estado: {tarea.estado || 'pendiente'}
                </span>
              </div>

              <div className="flex items-center gap-2 mt-2">
                <input
                  type="range"
                  min="0"
                  max="100"
                  value={tarea.progreso || 0}
                  onChange={(e) =>
                    actualizarProgreso(tarea.idTarea, parseInt(e.target.value))
                  }
                />
                <span>{tarea.progreso || 0}%</span>
              </div>
            </li>
          ))}
        </ul>
      )}
    </div>
  );
};

export default TareaResumen;

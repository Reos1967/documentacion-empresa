import React, { useEffect, useState } from 'react';

const NotificacionesResumen = () => {
  const [notificaciones, setNotificaciones] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/api/notificaciones')
      .then(res => res.json())
      .then(data => setNotificaciones(data))
      .catch(err => console.error('Error al cargar notificaciones', err));
  }, []);

  return (
    <div>
      <h3 className="text-xl font-bold mb-2">Notificaciones recientes</h3>
      {notificaciones.length === 0 ? (
        <p className="text-gray-600">No hay notificaciones recientes.</p>
      ) : (
        <ul className="list-disc list-inside">
          {notificaciones.slice(0, 5).map((n) => (
            <li key={n.idNotificacion}>
              {n.mensaje} ({new Date(n.fecha).toLocaleDateString()})
            </li>
          ))}
        </ul>
      )}
    </div>
  );
};

export default NotificacionesResumen;

import React from 'react';

const CalendarioResumen = () => {
  return (
    <div>
      <h2 className="text-2xl font-bold mb-4">Resumen del Calendario</h2>
      <p className="text-gray-700">Aquí irán los eventos próximos y recordatorios asignados.</p>
      <ul className="mt-4 list-disc list-inside">
        <li>Reunión con equipo de SAC - 5 junio, 9:00 AM</li>
        <li>Entrenamiento Nivel 1 - 6 junio, 2:00 PM</li>
        <li>Entrega de informe mensual - 10 junio</li>
      </ul>
    </div>
  );
};

export default CalendarioResumen;

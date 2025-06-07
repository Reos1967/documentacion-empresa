import React, { useState, useEffect } from 'react';
import { useParams, useNavigate } from 'react-router-dom';

const ManualEdit = () => {
  const { id } = useParams();
  const navigate = useNavigate();

  const [manual, setManual] = useState({ titulo: '', contenido: '', categoria: '' });

  useEffect(() => {
    fetch(`http://localhost:8080/api/manuales/${id}`)
      .then(res => res.json())
      .then(data => setManual(data));
  }, [id]);

  const handleSubmit = async (e) => {
    e.preventDefault();
    await fetch(`http://localhost:8080/api/manuales/${id}`, {
      method: 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(manual)
    });
    navigate('/manuales');
  };

  return (
    <div className="max-w-2xl mx-auto mt-10">
      <h2 className="text-xl font-bold mb-4">Editar Manual</h2>
      <form onSubmit={handleSubmit} className="space-y-4">
        <input value={manual.titulo} onChange={e => setManual({ ...manual, titulo: e.target.value })} className="border p-2 w-full" required />
        <input value={manual.categoria} onChange={e => setManual({ ...manual, categoria: e.target.value })} className="border p-2 w-full" />
        <textarea value={manual.contenido} onChange={e => setManual({ ...manual, contenido: e.target.value })} className="border p-2 w-full h-40" required />
        <button className="bg-yellow-500 text-white px-4 py-2 rounded">Guardar Cambios</button>
      </form>
    </div>
  );
};

export default ManualEdit;

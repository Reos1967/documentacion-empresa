import React, { useState, useContext } from 'react';
import { useNavigate } from 'react-router-dom';
import { UsuarioContext } from '../context/UsuarioContext';

const ManualForm = () => {
  const { usuario } = useContext(UsuarioContext);
  const navigate = useNavigate();

  const [titulo, setTitulo] = useState('');
  const [contenido, setContenido] = useState('');
  const [categoria, setCategoria] = useState('');
  const [error, setError] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();
    setError('');

    const manual = {
      titulo,
      contenido,
      categoria,
      usuario: { idUsuario: usuario.idUsuario }
    };

    try {
      const res = await fetch('http://localhost:8080/api/manuales', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(manual)
      });

      if (res.ok) {
        navigate('/manuales');
      } else {
        setError('Error al guardar el manual');
      }
    } catch (err) {
      setError('Error de conexión');
    }
  };

  return (
    <div className="max-w-2xl mx-auto mt-10">
      <h2 className="text-xl font-bold mb-4">Crear Manual</h2>

      <form onSubmit={handleSubmit} className="space-y-4">
        <input
          type="text"
          placeholder="Título del manual"
          className="border p-2 w-full"
          value={titulo}
          onChange={(e) => setTitulo(e.target.value)}
          required
        />

        <input
          type="text"
          placeholder="Categoría (Ej: Soporte, SAC, Retención)"
          className="border p-2 w-full"
          value={categoria}
          onChange={(e) => setCategoria(e.target.value)}
        />

        <textarea
          placeholder="Contenido paso a paso..."
          className="border p-2 w-full h-40"
          value={contenido}
          onChange={(e) => setContenido(e.target.value)}
          required
        ></textarea>

        {error && <p className="text-red-500">{error}</p>}

        <button className="bg-green-600 text-white px-4 py-2 rounded">Guardar Manual</button>
      </form>
    </div>
  );
};

export default ManualForm;

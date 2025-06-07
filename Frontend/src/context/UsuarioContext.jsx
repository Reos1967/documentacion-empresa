import React, { createContext, useState, useEffect } from 'react';

// 1. Crear el contexto
export const UsuarioContext = createContext();

// 2. Crear el proveedor
export const UsuarioProvider = ({ children }) => {
  const [usuario, setUsuario] = useState(null);

  // Leer usuario desde localStorage al iniciar
  useEffect(() => {
    const data = localStorage.getItem('usuario');
    if (data) {
      setUsuario(JSON.parse(data));
    }
  }, []);

  // Función para cerrar sesión
  const logout = () => {
    localStorage.removeItem('usuario');
    setUsuario(null);
  };

  return (
    <UsuarioContext.Provider value={{ usuario, setUsuario, logout }}>
      {children}
    </UsuarioContext.Provider>
  );
};

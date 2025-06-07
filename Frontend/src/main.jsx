import React from 'react';
import ReactDOM from 'react-dom/client';
import { BrowserRouter } from 'react-router-dom';
import App from './App.jsx';
import './styles.css';
import { UsuarioProvider } from './context/UsuarioContext'

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <BrowserRouter>
      <UsuarioProvider> {/* ✅ Aquí envolvemos todo */}
        <App />
      </UsuarioProvider>
    </BrowserRouter>
  </React.StrictMode>
);

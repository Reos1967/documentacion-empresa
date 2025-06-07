import { Routes, Route } from 'react-router-dom';
import Login from './pages/Login';
import TareaResumen from './pages/TareaResumen'; // <-- asegúrate de tener este
import CalendarioResumen from './pages/CalendarioResumen'; // <-- asegúrate de tener este
import Dashboard from './pages/Dashboard';
import ManualList from './pages/ManualList';
import ManualEdit from './pages/ManualEdit';
import UsuarioList from './pages/UsuarioList'; // (Crea este archivo si no lo tienes)
import NotificacionesResumen from './pages/NotificacionesResumen';
import LayoutDashboard from './components/LayoutDashboard';

const App = () => {
  return (
   
  <Routes>
    <Route path="/" element={<Login />} />
    <Route element={<LayoutDashboard />}>
      <Route path="/dashboard" element={<Dashboard />} />
      <Route path="/manuales" element={<ManualList />} />
      <Route path="/manuales/editar/:id" element={<ManualEdit />} />
      <Route path="/usuarios" element={<UsuarioList />} />
      <Route path="/notificaciones" element={<NotificacionesResumen />} />
      <Route path="/calendario" element={<CalendarioResumen />} />
      <Route path="/tareas" element={<TareaResumen />} />
    </Route>
  </Routes>
  );
};

export default App;

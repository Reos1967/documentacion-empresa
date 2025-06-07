// Frontend/src/services/tareaService.js

// Define la URL base de tu API de Spring Boot
// Asegúrate de que esta URL coincida exactamente con la dirección de tu backend
const API_BASE_URL = 'http://localhost:8080/api';

/**
 * Obtiene todas las tareas del backend.
 * @returns {Promise<Array>} Una promesa que resuelve con un array de objetos de tarea.
 * @throws {Error} Si la petición HTTP falla o la respuesta no es OK.
 */
export const getAllTareas = async () => {
    try {
        const response = await fetch(`${API_BASE_URL}/tareas`);
        
        // Verifica si la respuesta HTTP es exitosa (código 2xx)
        if (!response.ok) {
            // Si no es exitosa, lanza un error con el estado de la respuesta
            const errorText = await response.text(); // Intenta leer el texto de error de la respuesta
            throw new Error(`Error al obtener tareas: ${response.status} - ${response.statusText}. Detalles: ${errorText}`);
        }
        
        const data = await response.json(); // Parsea la respuesta JSON
        return data;
    } catch (error) {
        console.error("Error en getAllTareas:", error);
        // Puedes relanzar el error o retornar un valor por defecto si lo prefieres
        throw error; 
    }
};

/**
 * Crea una nueva tarea en el backend.
 * @param {Object} tareaData Los datos de la tarea a crear (ej. { titulo, descripcion, estado, porcentajeProgreso, fechaLimite, usuario: { idUsuario } }).
 * @returns {Promise<Object>} Una promesa que resuelve con el objeto de tarea creado por el backend.
 * @throws {Error} Si la petición HTTP falla, la respuesta no es OK, o hay un error de validación.
 */
export const createTarea = async (tareaData) => {
    try {
        const response = await fetch(`${API_BASE_URL}/tareas`, {
            method: 'POST', // Método HTTP POST para crear
            headers: {
                'Content-Type': 'application/json', // Indica que el cuerpo de la petición es JSON
                // Si tu backend requiere algún token de autenticación (ej. JWT),
                // lo añadirías aquí: 'Authorization': `Bearer ${tuTokenJWT}`
            },
            body: JSON.stringify(tareaData) // Convierte el objeto JavaScript a una cadena JSON
        });

        if (!response.ok) {
            // Si la respuesta no es exitosa, intenta leer el cuerpo del error del backend
            const errorData = await response.json().catch(() => response.text()); // Intenta JSON, si falla, lee como texto
            const errorMessage = typeof errorData === 'object' && errorData.message ? errorData.message : errorData;
            throw new Error(`Error al crear tarea: ${response.status} - ${response.statusText}. Detalles: ${errorMessage}`);
        }

        const data = await response.json(); // Parsea la respuesta JSON del backend (la tarea creada)
        return data;
    } catch (error) {
        console.error("Error en createTarea:", error);
        throw error;
    }
};

// Puedes añadir aquí más funciones como updateTarea, deleteTarea, getTareaById, etc.
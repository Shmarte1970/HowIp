window.addEventListener('DOMContentLoaded', function() {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            var contenido = xhr.responseText;
            document.getElementById("contenido-label").textContent = contenido;
        }
    };
    xhr.open('GET', 'historialIP.txt', true);
    xhr.send();
});
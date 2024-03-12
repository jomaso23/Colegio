function cargar() {
    //console.log('cargando elementos!')
}

//Cargando Hora
function ActualizarHora() {
    date = new Date()
    segundos = date.getSeconds()
    minutos = date.getMinutes()
    horas = date.getHours()

    hora = horas.toString().padStart(2, "0") + ":" +
        minutos.toString().padStart(2, "0") + ":" +
        segundos.toString().padStart(2, "0")
    fecha = date.getDate().toString().padStart(2, "0") + "/" +
        (date.getMonth() + 1).toString().padStart(2, "0") + "/" +
        (date.getYear() + 1900).toString().padStart(4, "0")
    document.getElementById('fecha').value = fecha
    document.getElementById('hora').setAttribute('value', hora)
}

setInterval(ActualizarHora, 1000)

async function getIpClient() {
    try {
        const response = await axios.get('https://api.ipify.org?format=json');
        ip = response.data.ip
        let arrayIP = ip.split('.')
        let stringIP = ''
        for (var i = 0; i < arrayIP.length; i++) {
            stringIP = stringIP + arrayIP[i].padStart(3, "0")
            if (i != arrayIP.length - 1) stringIP = stringIP + "."
        }
        document.getElementById('ip_publica').setAttribute('value', stringIP)
    } catch (error) {
        console.error(error);
    }
}
getIpClient();

async function getIpPrivate(){
    try {
        const response = await axios.get('http://192.168.20.198:8095/ipServer');
        //console.log(response.data)
        ip = response.data
        let arrayIP = ip.split('.')
        let stringIP = ''
        for (var i = 0; i < arrayIP.length; i++) {
             stringIP = stringIP + arrayIP[i].padStart(3, "0")
             if (i != arrayIP.length - 1) stringIP = stringIP + "."
        }
        document.getElementById('ip_privada').setAttribute('value', stringIP)
    } catch (error) {
        console.error(error);
    }
}
getIpPrivate()
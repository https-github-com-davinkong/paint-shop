let loginForm = document.getElementById('login-form')
let loginEmail = document.getElementById('login-email')
let loginPassword = document.getElementById('login-password')

//Cookie
const cookieArr = document.cookie.split("=")
const userId = cookieArr[1];



const headers = {
    'Content-Type':'application/json'
}

const baseUrl = 'http://localhost:8080/api/v1/contractors'

const handleSubmit = async (e)=>{
    e.preventDefault();

    let bodyObj = {
        'email': loginEmail.value,
        'password': loginPassword.value,
    }

    const response = await fetch(`${baseUrl}/login`, {
        method: 'POST',
        body: JSON.stringify(bodyObj),
        headers: headers
    })
        .catch(err => console.error(err.message))

    const responseArr = await response.json()



    if(response.status === 200){
        document.cookie = `userId=${responseArr[1]}`
        window.location.replace(responseArr[0])

    }else{
        alert("Wrong Username Or Password!")
        window.location.replace("http://localhost:8080/html/RegisterLogin/login.html")
    }


}
function handleLogout(){
    let c = document.cookie.split(";");
    for(let i in c){
        document.cookie = /^[^=]+/.exec(c[i])[0]+"=;expires=Thu, 01 Jan 1970 00:00:00 GMT"
    }
}

loginForm.addEventListener("submit", handleSubmit)


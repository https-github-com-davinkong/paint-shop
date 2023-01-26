
const registerForm = document.getElementById('register-form')
const registerFirstName = document.getElementById('register-fName')
const registerLastName = document.getElementById('register-lName')
const registerEmail = document.getElementById('register-email')
const registerPassword = document.getElementById('register-password')

const headers = {
    'Content-Type':'application/json'
}

const baseUrl = 'http://localhost:8080/api/v1/contractors'


const handleSubmit = async (e) =>{
    e.preventDefault()

    let bodyObj = {
        firstName: registerFirstName.value,
        lastName: registerLastName.value,
        email: registerEmail.value,
        password: registerPassword.value
    }

    const response = await fetch(`${baseUrl}/register`, {
        method: "POST",
        body: JSON.stringify(bodyObj),
        headers: headers
    })
        .catch(err => console.error(err.message))

    const responseArr = await response.json()

    if (response.status === 200){
        window.location.replace(responseArr[0])
    }else if (response.status === 500){
        alert("Username already existed")
        window.location.replace("http://localhost:8080/html/RegisterLogin/register.html")
    }
}


registerForm.addEventListener("submit", handleSubmit)



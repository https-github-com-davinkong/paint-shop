//Cookie
const cookieArr = document.cookie.split("=")
const contractorsId = cookieArr[1];

const headers = {
    'Content-Type':'application/json'
}

const baseUrl = 'http://localhost:8080/api/v1/products'

// GET DOM ELEMENTS
const productForm = document.getElementById('product-form')
const productPaintColor = document.getElementById('product-paintColor')
const productDescription = document.getElementById('product-description')
const productTools = document.getElementById('product-tools')

// POST a product
const handleSubmit = async (e) =>{
    e.preventDefault()
    let bodyObj = {
        paintColor: productPaintColor.value,
        tools: productTools.value,
        description: productDescription.value,

    }
    const response = await fetch(`${baseUrl}/product`, {
        method: "POST",
        body: JSON.stringify(bodyObj),
        headers: headers
    })
        .catch(err => console.error(err.message))
//    const result = await response.json()
    if (response.status == 200){
        console.log("product added")
    }
    window.location.replace("http://localhost:8080/products")
}

productForm.addEventListener("submit", handleSubmit)


// LOGOUT button
function handleLogout(){
    let c = document.cookie.split(";");

    for(let i in c){
        document.cookie = /^[^=]+/.exec(c[i])[0]+"=;expires=Thu, 01 Jan 1970 00:00:00 GMT"
    }

}



//Cookie
const cookieArr = document.cookie.split("=")
const contractorsId = cookieArr[1];

if (contractorsId == null){
    window.alert("You are not authorized to access this page...");
    window.location.replace("http://localhost:8080/html/RegisterLogin/login.html");
}
function handleLogout(){
    let c = document.cookie.split(";");

    for(let i in c){
        document.cookie = /^[^=]+/.exec(c[i])[0]+"=;expires=Thu, 01 Jan 1970 00:00:00 GMT"
    }

}





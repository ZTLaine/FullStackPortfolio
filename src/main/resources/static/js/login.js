var submitBtn = document.querySelector("#submitBtn")
var usernameTextBox = document.querySelector("#username")
var users = []

submitBtn.addEventListener('click', () => {
    var username = document.querySelector("#username")
    var password = document.querySelector("#password")

    if (username.value == '' || password.value == '') {
        alert("Please enter a username and a password.")
    } else {
        console.log(`Inputs present, able to submit.`)
        var user = {
            "username" : username.value,
            "password" : password.value
        }
        users.push(user)
    }
})

usernameTextBox.addEventListener('blur', () => {
    fetch("http://localhost:8080/users/exists")
    console.log("Blur event!")
})
var submitBtn = document.querySelector("#submitBtn")
var usernameTextBox = document.querySelector("#username")
var passwordTextBox = document.querySelector("#password")
var users = []

submitBtn.addEventListener('click', () => {
    var username = document.querySelector("#username")
    var password = document.querySelector("#password")

    if (username.value == '' || password.value == '') {
        alert("Please enter a username and a password.")
    } else {
        console.log(`Inputs present, able to submit.`)
        var user = {
            "username": username.value,
            "password": password.value
        }
        users.push(user)
    }
})

// Passing using get fetch api request
usernameTextBox.addEventListener('blur', () => {
    var user = {
        "username": usernameTextBox.value,
        "password": passwordTextBox.value
    }
    // fetch(`http://localhost:8080/users/exists?username=${usernameTextBox.value}&password=${passwordTextBox.value}`)
    fetch('users/exists', {
        method: 'POST',
        headers: {
            // Makes sure it's sent as JSON instead of just text
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
    }).then(response => response.json())
        .then(data => console.log(data))
})

passwordTextBox.addEventListener('blur', () => {
    var user = {
        "username": usernameTextBox.value,
        "password": passwordTextBox.value
    }
    fetch(`/users/passwordReqs`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(user)
    })
        .then((response => response.json()))
            .then(data => console.log(data))
})
var usernameTextBox = document.querySelector('#username')
var passwordTextBox = document.querySelector("#password")
var confirmPasswordTextBox = document.querySelector("#confirmPassword")

usernameTextBox.addEventListener('blur', () => {
    var user = {
        'username': usernameTextBox.value
    }
    fetch('users/exists', {
        method:'POST',
        headers: {
            'Content-Type':'application/json'
        },
        body: JSON.stringify(user)
    }).then((response => response.json()))
        .then((data) => {
        if(data === true){
            alert("This username is already taken!")
        }
    })
})

passwordTextBox.addEventListener('blur', () => {
    var user = {
        'password': passwordTextBox.value
    }
    fetch('users/passwordReqs', {
        method:'POST',
        headers: {
            'Content-Type':'application/json'
        },
        body: JSON.stringify(user)
    }).then((response => response.json()))
        .then((data) => {
            if(data === false){
                alert("Password must be 6-24 characters long.")
            }
        })
})

confirmPasswordTextBox.addEventListener('blur', () => {
    if(confirmPasswordTextBox.value !== passwordTextBox.value){
        alert("Passwords must match!")
    }

    // var user = {
    //     'password': passwordTextBox.value
    // }
    // fetch('users/passwordReqs', {
    //     method:'POST',
    //     headers: {
    //         'Content-Type':'application/json'
    //     },
    //     body: JSON.stringify(user)
    // }).then((response => response.json()))
    //     .then((data) => {
    //         if(data === false){
    //             alert("Password must be 6-24 characters long.")
    //         }
    //     })
})
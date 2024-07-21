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
            else {
                // passwordTextBox.color = `rgb(255, 255, 255)`
            }
        })
})

confirmPasswordTextBox.addEventListener('blur', () => {
    if(confirmPasswordTextBox.value !== passwordTextBox.value){
        // alert("Passwords must match!")
        showErrorAnimation(() => {
            //animation completed here
            console.log("In callback function")
        })
    }else{
        confirmPasswordTextBox.style.border = ``
    }
})

function showErrorAnimation(callback){
    console.log("In in animation function")
    var i = 255
    var animation = setInterval(() => {
        i--
        confirmPasswordTextBox.style.border = `2px solid rgb(255, ${i}, ${i})`
        if(i <= 0){
            clearInterval(animation)
            console.log("Done with animation")
            callback()
        }
    }, 1)
}
var usernameTextBox = document.querySelector('#username')
var passwordTextBox = document.querySelector("#password")
var confirmPasswordTextBox = document.querySelector("#confirmPassword")

var eyeIcons = document.querySelectorAll('.fa-eye')

eyeIcons.forEach((eyeIcon) => {
    eyeIcon.addEventListener('click', () => {
        // console.log(eyeIcon)
        if(eyeIcon.classList.contains('fa-eye')){
            eyeIcon.classList.replace('fa-eye', 'fa-eye-slash')
            if (eyeIcon.getAttribute('id') === 'passwordEyeIcon'){
                document.querySelector("#password").type = 'text'
            } else {
                document.querySelector("#confirmPassword").type = 'text'
            }
        } else {
            eyeIcon.classList.replace('fa-eye-slash', 'fa-eye')
            if (eyeIcon.getAttribute('id') === 'passwordEyeIcon'){
                document.querySelector("#password").type = 'password'
            } else {
                document.querySelector("#confirmPassword").type = 'password'
            }
        }
    })
})

usernameTextBox.addEventListener('blur', () => {
    var user = {
        'username': usernameTextBox.value
    }
    checkIfUserExists(user);
})

async function checkIfUserExists(user) {
    let response = await fetch('users/exists', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
    })
    let userExists = await response.json()

    if(userExists === true){
        alert("This username is already taken!")
    }
}

passwordTextBox.addEventListener('blur', () => {
    var user = {
        'password': passwordTextBox.value
    }
    fetch('users/passwordReqs', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
    }).then((response => response.json()))
        .then((data) => {
            if (data === false) {
                alert("Password must be 6-24 characters long.")
            } else {
                // passwordTextBox.color = `rgb(255, 255, 255)`
            }
        })
})

confirmPasswordTextBox.addEventListener('blur', () => {
    if (confirmPasswordTextBox.value !== passwordTextBox.value) {
        showErrorAnimation().then((message) => {
            console.log(message)
        })
    } else {
        confirmPasswordTextBox.style.border = ``
    }
})

function showErrorAnimation() {
    return new Promise((resolve, reject) => {
        var i = 255
        var animation = setInterval(() => {
            i -= 5
            confirmPasswordTextBox.style.border = `2px solid rgb(255, ${i}, ${i})`
            if (i <= 0) {
                clearInterval(animation)
                resolve("Done with animation code")
            }
        }, 20)
    })
}

// function showErrorAnimation(callback) {
//     console.log("In animation function")
//     var i = 255
//     var animation = setInterval(() => {
//         i--
//         confirmPasswordTextBox.style.border = `2px solid rgb(255, ${i}, ${i})`
//         if (i <= 0) {
//             clearInterval(animation)
//             console.log("Done with animation")
//             callback()
//         }
//     }, 1)
// }

// Promise demo
// var myPromise = new Promise((resolve, reject) => {
//     let i = 2
//
//     if( i === 1){
//         resolve("Hey i - 1, nice")
//     }
//     else{
//         reject("Well that didn't go quite right.  Fail. i != 1.")
//     }
// })
//
// myPromise.then((message) => {
//     console.log(message)
// }).catch((message => {
//     console.log(message)
// }))


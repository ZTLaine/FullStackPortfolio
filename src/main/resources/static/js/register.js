// var usernameTextBox = document.querySelector('#username')
//
// usernameTextBox.addEventListener('blur', () => {
//     var user = {
//         'username': usernameTextBox.value
//     }
//     fetch('users/exists', {
//         method:'POST',
//         headers: {
//             'Content-Type':'application/json'
//         },
//         body: JSON.stringify(user)
//     }).then((response => response.json()))
//         .then((data) => {
//         if(data === true){
//             alert("This username is already taken!")
//         }
//     })
// })
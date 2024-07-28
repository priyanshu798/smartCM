

console.log("script loaded");


let curTheme = getTheme()
changeTheme(curTheme)


function changeTheme() {
    //set to web page
    document.querySelector('html').classList.add(curTheme);  

    //listener to change theme
    const changeThemeButton =  document.querySelector('#theme-change-button')
    changeThemeButton.addEventListener('click', () => {
        console.log("Change theme button clicked");
        document.querySelector('html').classList.remove(curTheme);

        if (curTheme == "dark"){
            curTheme = "light"
        }
        else {
            curTheme = "dark"
        }
        //update local storage
        setTheme(curTheme);
        document.querySelector('html').classList.add(curTheme);

        changeThemeButton.querySelector('span').textContent = curTheme == 'light'?'Dark':'Light'
    });
}

document.addEventListener('DOMContentLoaded', () => {
    changeTheme
})

function setTheme(theme) {
    localStorage.setItem("theme", theme)

}

function getTheme() {
    let theme=localStorage.getItem("theme")
    if (theme) return theme
    else return "light"
    
}
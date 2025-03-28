function hideFuncAdd() {
    var x = document.getElementById("hidden-part-add");
    var button = document.getElementById("add-button");

    if (x.style.display === "none" || x.style.display === "") {  // Проверка дали е скрит
        x.style.display = "flex";
        button.textContent = "Hide"; // Променя текста на бутона
    } else {
        x.style.display = "none";
        button.textContent = "Add new Book";
    }
}

function hideFuncUpdate(button) {
    var row = button.closest("tr");
    var title = row.querySelector("td:nth-child(2)").innerText;
    var author = row.querySelector("td:nth-child(3)").innerText;
    var description = row.querySelector("td:nth-child(4)").innerText;
    var status = row.querySelector("td:nth-child(5)").innerText.trim().toUpperCase(); // Преобразуваме към главни букви и премахваме излишни интервали
    var form = row.querySelector("form[action='/update']");
    var hiddenPart = form.querySelector("#hidden-part");
  var table = document.querySelector(".table-update-delete");

    var titleInput = form.querySelector("#oldTitle");
    var titleField = form.querySelector("#title");
    var authorField = form.querySelector("#author");
    var descriptionField = form.querySelector("#description");
    var statusField = form.querySelector("#status");

    titleInput.value = title;  // Задава старото заглавие в hidden полето
    titleField.value = title;  // Задава старото заглавие в полето за новото заглавие
    authorField.value = author;  // Задава стария автор в полето за нов автор
    descriptionField.value = description;  // Задава старото описание в полето за ново описание

    // За да запишем стойността на статус в полето за избор
    if (status === "READ") {
        statusField.value = "READ";
    } else if (status === "TO READ" ) {
        statusField.value = "TO_READ";
    } else if (status === "READING") {
        statusField.value = "READING";
    }

    // Показва / скрива формата
    if (!hiddenPart.style.display || hiddenPart.style.display === "none") {
        hiddenPart.style.display = "block";
        table.style.display="block";

        button.style.display = "none";
        button.style.marginTop = "21px";

        var allButtons = document.querySelectorAll("button"); // Взема всички бутони в страницата
        var allDeleteButtons = document.querySelectorAll("button[id='delete-button']");

        // Скрива всички бутони освен "Add new Book" и "Save Changes"
        allButtons.forEach(btn => {
            if (btn !== button && btn.classList.contains("update-button") && btn.type !== "submit") {
                btn.style.display = "none";
            }
        });

        allDeleteButtons.forEach(btn => btn.style.display = "none");  // Скрива бутоните за изтриване
    } else {
        hiddenPart.style.display = "none";
      table.style.display="none";
        button.textContent = "Update Book"; // Променяме текста на бутона обратно
        button.style.marginTop = "0";

        allButtons = document.querySelectorAll("button"); // Взема всички бутони в страницата
        allDeleteButtons = document.querySelectorAll("button[id='delete-button']");

        // Връща видимостта на всички бутони
        allButtons.forEach(btn => {
            if (btn.classList.contains("update-button") && btn.type !== "submit") {
                btn.style.display = "block";
            }
        });

        allDeleteButtons.forEach(btn => btn.style.display = "block"); // Показва бутоните за изтриване обратно
    }
    toggleVisibilityOfReadParts()
}


//скрива заглавията и редовете, които не се ъпдейтват
function toggleVisibilityOfReadParts() {
    var x = document.getElementsByClassName("hidden-part-read");
    var table = document.getElementById("table-update-delete");
    for (var i = 0; i < x.length; i++) {
        if (x[i].style.visibility === "hidden") {
            x[i].style.visibility = "visible";
            table.style.display="block";
        } else {
            x[i].style.visibility = "hidden";
            table.style.display="none";

        }
    }
}
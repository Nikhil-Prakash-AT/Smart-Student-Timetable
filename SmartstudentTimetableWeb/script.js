let subjects = JSON.parse(localStorage.getItem("subjects")) || [];

const tbody = document.querySelector("#timetable tbody");
const addBtn = document.getElementById("addBtn");
const filterDay = document.getElementById("filterDay");

function saveSubjects() {
    localStorage.setItem("subjects", JSON.stringify(subjects));
}

function renderTable(day = "") {
    tbody.innerHTML = "";
    subjects
        .filter(s => !day || s.day === day)
        .forEach((s, index) => {
            const row = document.createElement("tr");
            row.innerHTML = `
                <td>${s.name}</td>
                <td>${s.day}</td>
                <td>${s.start}</td>
                <td>${s.end}</td>
                <td>
                    <button class="action-btn edit" onclick="editSubject(${index})">Edit</button>
                    <button class="action-btn" onclick="deleteSubject(${index})">Delete</button>
                </td>
            `;
            tbody.appendChild(row);
        });
}

function addSubject() {
    const name = document.getElementById("subject").value;
    const day = document.getElementById("day").value;
    const start = document.getElementById("start").value;
    const end = document.getElementById("end").value;

    if(!name || !day || !start || !end){
        alert("Please fill all fields!");
        return;
    }

    subjects.push({name, day, start, end});
    saveSubjects();
    renderTable(filterDay.value);

    document.getElementById("subject").value = "";
    document.getElementById("start").value = "";
    document.getElementById("end").value = "";
}

function deleteSubject(index){
    if(confirm("Are you sure you want to delete this subject?")){
        subjects.splice(index,1);
        saveSubjects();
        renderTable(filterDay.value);
    }
}

function editSubject(index){
    const s = subjects[index];
    const name = prompt("Edit subject name:", s.name);
    const day = prompt("Edit day:", s.day);
    const start = prompt("Edit start time:", s.start);
    const end = prompt("Edit end time:", s.end);

    if(name && day && start && end){
        subjects[index] = {name, day, start, end};
        saveSubjects();
        renderTable(filterDay.value);
    }
}

addBtn.addEventListener("click", addSubject);
filterDay.addEventListener("change", ()=> renderTable(filterDay.value));

renderTable();

const bikeForm = document.getElementById("bikeForm");
const bikeTableBody = document.getElementById("bikeTableBody");

// 1. Fetch bikes from backend (Updated with Delete Button)
function fetchBikes() {
    fetch('http://localhost:8080/api/bikes')
        .then(res => res.json())
        .then(data => {
            bikeTableBody.innerHTML = "";
            data.forEach((bike, index) => {
                const row = document.createElement("tr");
                row.innerHTML = `
                    <td>${index + 1}</td>
                    <td>${bike.brand}</td>
                    <td>${bike.name}</td>
                    <td>${bike.avgSpeed}</td>
                    <td>${bike.price}</td>
                    <td>
                        <button class="delete-btn" onclick="deleteBike(${bike.id}, this)">Delete</button>
                    </td>
                `;
                bikeTableBody.appendChild(row);
            });
        });
}

// 2. Add bike logic
bikeForm.addEventListener("submit", e => {
    e.preventDefault();
    const bike = {
        brand: document.getElementById("brand").value.trim(),
        name: document.getElementById("name").value.trim(),
        avgSpeed: parseInt(document.getElementById("speed").value),
        price: parseFloat(document.getElementById("price").value)
    };

    fetch('http://localhost:8080/api/bikes', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(bike)
    }).then(() => {
        fetchBikes();
        bikeForm.reset();
    }).catch(err => console.error("Error adding bike:", err));
});

// 3. Delete bike logic (New Function)
function deleteBike(id, buttonElement) {
    if (confirm("Kya aap ise delete karna chahte hain?")) {
        fetch(`http://localhost:8080/api/bikes/${id}`, {
            method: 'DELETE'
        })
        .then(res => {
            // Agar backend se delete successful ho jaye
            if (res.ok) {
                // 'buttonElement' ka use karke sidhe row ko remove karein
                const row = buttonElement.closest('tr');
                row.remove();
                
                // Serial numbers (1, 2, 3...) ko refresh karein
                const rows = bikeTableBody.querySelectorAll('tr');
                rows.forEach((r, index) => {
                    r.cells[0].innerText = index + 1;
                });
            } else {
                alert("Backend se delete nahi ho paya. Route check karein.");
            }
        })
        .catch(err => {
            console.error("Error:", err);
            // Agar API error de rahi hai phir bhi screen se hatana chahte hain toh:
            buttonElement.closest('tr').remove();
        });
    }
}

// Initial fetch
fetchBikes();
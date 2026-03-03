async function loadProfileData() {
    try {
        // This fetches the data from your Spring Boot Java API
        const response = await fetch('/app');
        const data = await response.json();
        const profile = data[0]; // Accessing the first record

        // Update the About Section
        document.getElementById('profile-info').innerHTML = `
            <h2>${profile.fullName}</h2>
            <p>${profile.summary}</p>
            <p><strong><i class="fas fa-envelope"></i></strong> ${profile.email}</p>
        `;

        // Update the Experience Section
        const expContainer = document.getElementById('experience-list');
        expContainer.innerHTML = profile.experiences.map(exp => `
            <div class="card">
                <h3>${exp.role}</h3>
                <p><strong>${exp.company}</strong> | ${exp.tenure}</p>
                <p>${exp.description}</p>
            </div>
        `).join('');

    } catch (error) {
        console.error("Data fetch failed:", error);
        document.getElementById('profile-info').innerText = "Unable to load profile data.";
    }
}

// Run the function when the page loads
window.onload = loadProfileData;

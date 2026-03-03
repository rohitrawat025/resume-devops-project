const textArray = ["DevOps Engineer", "AWS Specialist", "Docker & Jenkins Expert"];
let typingIndex = 0;
let charIndex = 0;

function typeEffect() {
    if (charIndex < textArray[typingIndex].length) {
        document.querySelector(".typing").innerHTML += textArray[typingIndex].charAt(charIndex);
        charIndex++;
        setTimeout(typeEffect, 100);
    } else {
        setTimeout(() => {
            document.querySelector(".typing").innerHTML = "";
            charIndex = 0;
            typingIndex = (typingIndex + 1) % textArray.length;
            typeEffect();
        }, 1500);
    }
}

window.onload = function() {
    typeEffect();
    loadProfileData();
};

function scrollToSection(id) {
    document.getElementById(id).scrollIntoView({behavior: "smooth"});
}

async function loadProfileData() {
    try {
        const response = await fetch('/app');
        const data = await response.json();
        const profile = data[0];

        document.getElementById('profile-info').innerHTML = `
            <h3>${profile.fullName}</h3>
            <p>${profile.summary}</p>
            <p>${profile.email}</p>
        `;

        document.getElementById('experience-list').innerHTML =
            profile.experiences.map(exp => `
                <div class="glass-card">
                    <h4>${exp.role}</h4>
                    <p><strong>${exp.company}</strong> | ${exp.tenure}</p>
                    <p>${exp.description}</p>
                </div>
            `).join('');

    } catch (err) {
        console.error(err);
    }
}

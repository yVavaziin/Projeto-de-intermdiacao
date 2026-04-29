// home.js
// Faz o scroll suave para as âncoras da página
document.querySelectorAll('a[href^="#"]').forEach(anchor => {
    anchor.addEventListener('click', function (e) {
        e.preventDefault();
        document.querySelector(this.getAttribute('href')).scrollIntoView({
            behavior: 'smooth'
        });
    });
});

// Animação simples de entrada das seções
const faders = document.querySelectorAll('.step-card, .impact-item');
const appearOptions = { threshold: 0.15, rootMargin: "0px 0px -50px 0px" };

const appearOnScroll = new IntersectionObserver(function(entries, appearOnScroll) {
    entries.forEach(entry => {
        if (!entry.isIntersecting) return;
        entry.target.classList.add('appear');
        appearOnScroll.unobserve(entry.target);
    });
}, appearOptions);

faders.forEach(fader => {
    fader.style.opacity = "0";
    fader.style.transform = "translateY(20px)";
    fader.style.transition = "all 0.6s ease-out";
    appearOnScroll.observe(fader);
});

// Adiciona a classe de animação via JS para evitar CSS extra
document.styleSheets[0].insertRule('.appear { opacity: 1 !important; transform: translateY(0) !important; }', 0);
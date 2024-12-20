
document.addEventListener("DOMContentLoaded", () => {
    const form = document.querySelector("form");

    form.addEventListener("submit", async (event) => {
        event.preventDefault(); // Prevent the default form submission

        // Gather form data
        const formData = {
            email: document.getElementById("email").value,
            password: document.getElementById("password").value,
        };

        try {
            // Send a POST request to the /api/auth/login endpoint
            const response = await fetch("/api/auth/login", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(formData),
            });

            if (response.ok) {
                // Parse the response and extract the token
                const data = await response.json();
                const token = data.token;
                const decodedToken = JSON.parse(atob(token.split('.')[1]));
                const role = decodedToken.role;
                // Store the token in localStorage or sessionStorage
                localStorage.setItem("authToken", token);
                localStorage.setItem("role", role);

                // Redirect to a protected page (example: welcome page)
                window.location.href = "../welcome";
            } else {
                // Handle login failure (e.g., invalid credentials)
                alert("Failed to log in. Please check your credentials.");
            }
        } catch (error) {
            console.error("Error during login:", error);
            alert("An unexpected error occurred. Please try again.");
        }
    });
});

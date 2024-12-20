document.addEventListener("DOMContentLoaded", () => {
    const form = document.querySelector("form");

    form.addEventListener("submit", async (event) => {
        event.preventDefault(); // Prevent the default form submission

        // Gather form data
        const formData = {
            name: document.getElementById("fullname").value,
            email: document.getElementById("email").value,
            password: document.getElementById("password").value,
            role: document.querySelector("select[name='RoleSelection']").value,
            CourseListID: -1
        };

        try {
            // Send a POST request to "/api/user"
            const response = await fetch("/api/auth/register", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(formData),
            });

            // Check if registration is successful
            if (response.ok) {
                // Registration successful, redirect to welcome page
                const data = await response.json();
                if (data.token) {
                const token = data.token;
                const decodedToken = JSON.parse(atob(token.split('.')[1]));
                const role = decodedToken.role;
                // Store the token in localStorage or sessionStorage
                localStorage.setItem("authToken", token);
                localStorage.setItem("role", role);
                window.location.href = "../welcome";}
            } else {
                // If the response is not OK, show an alert with the error message
                // const data = await response.json();
                const errorData = await response.json();
                const errorMessage = errorData.message || "Failed to sign up. Please try again.";
                alert(errorMessage);
                window.location.href = "../signup"
                resetFormFields();
            }
        } catch (error) {
            console.error("Error submitting form:", error);
            alert("An unexpected error occurred. Please try again.");
            window.location.href = "../signup"
            resetFormFields();
        }
    });
    function resetFormFields() {
        // Reset form fields
        document.getElementById("fullname").value = "";
        document.getElementById("email").value = "";
        document.getElementById("password").value = "";
        document.getElementById("role").value = "";

        // Reset error message
        errorMessageDiv.textContent = "";
    }
});

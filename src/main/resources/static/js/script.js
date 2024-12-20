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
/*
private int userID;

	private String name;

	@Column(unique = true, nullable = false)
	private String email;

	private String password;

	@Enumerated(EnumType.STRING)
	private Role role;

	private int CourseListID;
*/
        try {
            // Send a POST request to "/Users"
            const response = await fetch("/Users", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(formData),
            });

            if (response.ok) {
                // Redirect to welcome.html
                window.location.href = "../welcome.html";
            } else {
                // Handle errors
                alert("Failed to sign up. Please try again.");
            }
        } catch (error) {
            console.error("Error submitting form:", error);
            alert("An unexpected error occurred. Please try again.");
        }
    });
});

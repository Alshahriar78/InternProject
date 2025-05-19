## Problem Faced 
1. After add session Mangesment stateless . facing NullPointerException(NPE) when try to login.



# Session Management

Session management is how a web server remembers who you are and what you've done as you move between pages or make requests. HTTP itself is stateless, so we need a way to track a "session" of interactions.

# Why We Need Session Management

Authentication: Keep you logged in after you enter your username and password.

Personalization: Remember your language, theme, or other preferences.

Shopping Carts: Keep track of items you’ve added until you check out.

Multi-Step Processes: Store data across steps (e.g., forms or wizards).

How Session Management Works

Create a Session IDWhen you log in or start an action, the server generates a unique ID (e.g., a random string).

Store Session DataThe server saves your ID with your information (like user ID or cart items) in memory, a database, or a cache.

Send a CookieThe server sends a cookie (e.g., SESSIONID=abc123) to your browser.

Include Cookie in RequestsYour browser sends the cookie with each request to the server.

Lookup and RestoreThe server reads the cookie, finds your session data by ID, and restores your context.

Expire or DestroySessions can expire after a set time or when you log out. The server deletes the session data and the browser’s cookie becomes invalid.

Security & Scaling

Security: Use secure, HTTP-only cookies to prevent theft and set proper expiration.

Scaling: For multiple servers or instances, store sessions in a shared store (e.g., Redis).

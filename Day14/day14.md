## Core Concepts of Spring Security
*Authentication — Who are you? Can you prove it?
*Authorization — After authenticate Can you do this? 
*Principal -> is a person who is authentication through authentication manager. It,s a Object of that parson
*Granted Authority
*Role
*AuthenticationManager -> is a spring security interface which deals with to check either  user is authenticated or not. if user is authenticated through credentted(username,password) then  pricipal retrun suscess authenticad object  if not then return  AuthenticationException .


Concept	                         
AuthenticationManager	    Login Validation 
UserDetailsService	        dettails from Database 
PasswordEncoder          	Password  encrypt/decrypt 
SecurityFilterChain     	which  URL are  protect  define that
AuthenticationProvider  	Authentication Logic  customize 


## @EnableWebSecurity 
Start the spring security authoConfiguration
Advantage of custom security configuration
Advantage of @override default security configuration
CSRF, CORS, Session Management, Authentication, Authorization controll this.
**⚠️ WARNING:** using @EnableWebSedcurity then disable spring boot auto-configured security

## SecurityFilterChain 
is a spring security's interface who determine how to secure a Http request by filtering.
is a sequence of security filters that are applied to each incoming HTTP request
it works with 
* authentication
* authorization
* CSRF,
* session management etc.
## .authorizeHttpRequest()
is a spring security method that Configures how certain requests are accessed.
*  exampple=> .authorizeHttpRequests((requests) -> requests
				.requestMatchers("/", "/home").permitAll()
				.anyRequest().authenticated()
			)
## requestMatchers()
is also a spring security method that determind which api/url  can be accessed
*  example => .requestMatchers("/", "/home").permitAll()
          .requestMatchers("/admin/**").hasRole("ADMIN")




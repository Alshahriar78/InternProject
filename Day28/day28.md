Authentication auth = SecurityContextHolder.getContext().getAuthentication();
String username = auth.getName();
Users user = usersRepository.findByEmail(username); // Or by username

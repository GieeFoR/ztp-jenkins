# Jenkins

Jenkins to narzędzie służące do automatyzacji, więcej o nim można przeczytać [tutaj](https://www.jenkins.io/).

1. Należy napisać program w Javie którego budowanie oraz testowanie będzie później automatyzowane za pomocą Jenkins
   1. Program ma być stworzony z użyciem Gradle
   2. program ma udostępniać endpoint `user` zwracający jednego użytkownika
   3. zwracany użytkownik powinien być losowo wybranym użytkownikiem spośród tych zwrazanych przez `https://gorest.co.in/public/v2/users`
   4. endpoint `user` ma przyjmować opcjonalny parametr `persist` typu `boolean` który gdy ma wartość `true` poza zwróceniem użytkownika powinien go zapisać także do bazy danych
   5. program ma udostępniac endpoint `users` zwracający wszystkich użytkowników dotychczas zapisanych do bazy danych
   6. program ma mieć testy automatyczne
2. Należy stworzyć kontener Dockera z Jenkinsem który będzie budował i testował projekt
   1. build w Jenkinsie ma startować automatycznie i ma budować oraz testować projekt
   2. build ma startować automatycznie po każdym commitcie do repozytorium na githubie gdzie znajduje się serwis w Javie
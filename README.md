Fitness Domain
==============

Planowanie grafiku zajęć
------------------------

1. Zajęcia mają przypisane: dzien w tygodniu, godzinę rozpoczęcia, czas trwania, trenera prowadzącego. Np.: we wtorki o 17:00 odbywają się zajęcia z podnoszenia ciężarów prowadzone przez Tomka.
2. Na podstawie grafiku dostępne są konkretne terminy zajęć, np.: podnoszenie ciężarów we wtorek 17 stycznia o 17:00.
3. Administrator może odwołać konkretny termin zajęć (np. z powodu święta)

Trenerzy
--------

1. Trener może prowadzić maksymalnie N niepokrywających się zajęć w tygodniu
2. Terener może prowadzić maksymalnie M zajęć w ciągu dnia
3. Terener może prowadzić zajęcia dla maksymalnie N osób (zależne np. od kwalifikacji, stażu itp)

Zapisy na zajęcia
-----------------

1. Można zapisać się na nie więcej niż 5 zajęć (w konretnym terminie) do przodu. Np.: zapisuję się na podnoszenie ciężarów w każdy dzień danego tygodnia na godzinę 19:00.
2. Na dane zajęcia zapisać się może nie więcej niż N osób (gdzie N jest specyficzne dla prowadzącego dane zajęcia)
3. Gdy w momencie zapisu nie ma wolnych miejsc, członek klubu jest wpisywany na listę rezerwową
4. Maksymalnie 6 osób może być na liście rezerwowej dla danego terminu zajęć.
5. Można zapisać się tylko na jedne zajęcia danego typu w ciągu jednego dnia

Odwoływanie rezerwacji
----------------------

1. Rezerwację można odwołać najpóźniej 1 godzinę przed terminem zajęć
2. Uczestnictwo w zajęciach potwierdzane jest przez zeskanowanie karty w klubie
3. Po trzeciej niepotwierdzonej rezerwacji (tzn. w przypadku gdy osoba zapisała się na zajęcia ale nie zeskanowała karty) następuje ban na zapisy na 4 dni.
4. Gdy ktoś odwoła rezerwację, to pierwsza osoba z listy rezerwowej dostaje się na listę uczestników danych zajęć. Wysyłany jest do niej SMS z powiadomieniem

Widoki
======

1. Kalendarz z wpisanymi zajęciami które można kliknąć i: a) członek klubu może się na nie zapisać, b) administrator może odwołać zajęcia c) administrator może przypisać trenera. Przy każdych zajęciach jest informacja o wolnych miejscach.
2. Lista zajęć na które zapisany jest zalogowany członek klubu + przyciski do anulowania zapisu
3. Widok administratora: grafik zajęć + formularz do dodania nowych pozycji
4. Widok trenera: lista osób zapisanych na dane zajęcia

Implementacje
=============

1. CRUD
2. Logika w encjach JPA (bez agregatów)
3. Agregaty z adnotacjami JPA (+ domain services)
4. Wyeliminowanie domain services
5. Osobne tabele na pola do odczytu (interfejs "listenera" w domenie)
6. Agregaty bez adnotacji JPA + repozytorium mapujące je na/z klasy JPA przy zapisie/odczycie (osobny model do rejestracji?)
7. Rejestrowanie eventów domenowych (jako dodatek do dotychczasowego repozytorium)
8. Event sourcing


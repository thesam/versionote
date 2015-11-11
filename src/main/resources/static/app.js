var app = angular.module("noteApp", []);

app.controller("NoteController", function($http) {
     var vm = this;


    fetchNotes();

    vm.createNote = function() {
        $http.post("/notes",{}).then(fetchNotes)
    };

    vm.updateNote = function() {
        $http.put("/notes/" + vm.selectedNote.id,vm.selectedNote).then(fetchNotes);
    }

    function fetchNotes() {
        $http.get("/notes").then(function (response) {
            vm.notes = response.data;
        });
    }
});
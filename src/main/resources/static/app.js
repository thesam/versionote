var app = angular.module("noteApp", ['ngMaterial']);

app.controller("NoteController", function($http, $mdToast,$document) {
     var vm = this;


    fetchNotes();

    function toast(msg) {
        $mdToast.show(
            $mdToast.simple()
                .content(msg)
                .position("top right")
                .parent($document[0].querySelector("#toastParent"))
                .hideDelay(2000)
        );
    }

    vm.createNote = function() {
        $http.post("/notes",{}).then(function() {
            toast("Note created");
            fetchNotes();
        })

    };

    vm.updateNote = function() {
        $http.put("/notes/" + vm.selectedNote.id,vm.selectedNote).then(function() {
            toast("Note updated");
            fetchNotes();
        })
    };

    function fetchNotes() {
        $http.get("/notes").then(function (response) {
            vm.notes = response.data;
        });
    }
});
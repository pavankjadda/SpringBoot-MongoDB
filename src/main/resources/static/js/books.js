var app = angular.module('books', ["ngRoute"]);

app.config(function($routeProvider)
{
    $routeProvider
        .when("/", {
            templateUrl : "../index.html"
        })
        .when("/save_book", {
            templateUrl : "../save_book.html"
        })
        .when("/edit_book/:id", {
            templateUrl : "../edit_book.html"
        })
        .when("/books", {
            templateUrl : "../books.html"
        });
});

app.controller('books_controller', function($scope,$http)
{

    $scope.get_books=function ()
    {
        $http({
            method : "GET",
            url : "/books"
        }).then(function mySuccess(response)
        {
            $scope.books_data = response.data;
        }, function myError(response)
        {
            $scope.myWelcome = response.statusText;
        });
    }


});


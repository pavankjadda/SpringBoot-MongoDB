var app = angular.module('edit_book', ["ngRoute"]);
app.controller('edit_book_controller', ['$scope','$http','$location','$routeParams',function($scope,$http, $location,$routeParams)
{
    $scope.validate_and_update_book=function ()
    {
        $http({
            method : "POST",
            url : "/books/save_book",
            data: JSON.stringify({title:$scope.title, cost:$scope.cost, numberOfPages:$scope.numberOfPages,author:$scope.author})

    }).then(function mySuccess(response)
        {
            $scope.form_error=false;
            $scope.form_success=true;
            $scope.form_success_message="Book information Updated ";
            $scope.form_success_message="";
            $scope.id=response.data.id;

        }, function myError(response)
        {
            $scope.form_error=true;
            $scope.form_success=false;
            $scope.form_success_message="";
            $scope.form_error_message="Unable to save Book, Please check the information";
        });
    };
    $scope.id=getIdFromUrl($location.absUrl());
    $scope.get_book_details=function ()
    {

        $http({
            method : "GET",
            url : "/books/"+$scope.id

        }).then(function mySuccess(response)
        {
            $scope.form_error=false;
            $scope.form_success=false;
            $scope.id=response.data.id;
            $scope.Title=response.data.title;
            $scope.cost=response.data.cost;
            $scope.numberOfPages=response.data.numberOfPages;
            $scope.author=response.data.author;

        }, function myError(response)
        {
            $scope.form_error=true;
            $scope.form_success=false;
            $scope.form_success_message="";
            $scope.form_error_message="Unable to load Book information, Please try again";
        });
    };

    function getIdFromUrl(url)
    {
        var regex = /id=(.*)#/;
        return regex.exec(url)[1];

    }
}]);


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
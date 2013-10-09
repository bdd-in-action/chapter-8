'use strict';

/* Controllers */

angular.module('flyinghigh.controllers', []).

    controller('LoginCtrl', function ($scope, $location, authentication) {
        var users = [
            {email: 'jane@acme.com', password: 's3cr3t', firstName: 'Jane', lastName: 'Smith'},
            {email: 'joe@acme.com', password: 's3cr3t2', firstName: 'Joe', lastName: 'Blogs'}
        ];

        $scope.status = 'Gold';
        $scope.auth = function () {
            var user
            for (var i = 0; i < users.length; i++) {
                if ((users[i].email == $scope.email) && (users[i].password == $scope.password)) {
                    user = users[i];
                }
            }
            if (user) {
                authentication.authenticateWith(user);
                $location.url('/home');
                $scope.authenticationError = '';
            } else {
                $scope.authenticationError = 'Sorry, wrong username or password';
            }
        };
    })
    .controller('HomeCtrl', function ($scope, authentication) {
        $scope.user = authentication.getUser();

        $scope.featured = [
            {title: "Singapore", price: 900, image: "img/singapore.png" },
            {title: "London", price: 1800, image: "img/london.jpg" },
            {title: "Sydney", price: 700, image: "img/sydney.png" }
        ]
    })
    .controller('BookCtrl', function ($scope, authentication) {
        $scope.user = authentication.getUser();
        $scope.travelClass = 'Economy';
        $scope.travelClasses = ['Economy', 'Premium Economy', 'Business', 'First'];

        $scope.depart = undefined;
        $scope.from = undefined;
        $scope.to = undefined;

        $scope.cities = function() {
            return ['Sydney', 'Melbourne', 'Brisbane', 'Perth', 'Auckland', 'Wellington', 'London', 'San Francisco',
                'New York', 'Los Angeles', 'Toronto', 'Singapore', 'Hong Kong', 'Seattle', 'Shanghai', 'Seoul', 'Sao Paulo'];
        };

        $scope.startsWith = function (state, viewValue) {
            return state.substr(0, viewValue.length).toLowerCase() == viewValue.toLowerCase();
        }
    });


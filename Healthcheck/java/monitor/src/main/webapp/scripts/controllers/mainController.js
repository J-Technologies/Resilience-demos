'use strict';

angular.module('mswFrontendApp')
        .controller('MainCtrl', ['$scope', '$rootScope', '$http', '$interval', function ($scope, $rootScope, $http, $interval) {
                $scope.initialize = function () {
                    $scope.loadData();
                    $interval($scope.loadData, 1000);
                }

                $scope.loadData = function () {
                    {
                        $http({
                            url: "resources/servers/getservers",
                            method: "GET",
                        }).success(
                                function (response) {
                                    $scope.servers = response;
                                })
                    }
                }

                $scope.initialize();

            }]
        );

angular.module('app', [])
    .controller('HillsController', ['$scope', '$http', '$window',
        function ($scope, $http, $window) {
            $scope.rows = [
                [{r:0, c:0, v:0}, {r:0, c:1, v:0}, {r:0, c:2, v:0}, {r:0, c:3, v:0}, {r:0, c:4, v:0}, {r:0, c:5, v:0}, {r:0, c:6, v:0}, {r:0, c:7, v:0}],
                [{r:1, c:0, v:1}, {r:1, c:1, v:0}, {r:1, c:2, v:0}, {r:1, c:3, v:0}, {r:1, c:4, v:0}, {r:1, c:5, v:0}, {r:1, c:6, v:0}, {r:1, c:7, v:1}],
                [{r:2, c:0, v:1}, {r:2, c:1, v:0}, {r:2, c:2, v:0}, {r:2, c:3, v:0}, {r:2, c:4, v:0}, {r:2, c:5, v:0}, {r:2, c:6, v:0}, {r:2, c:7, v:1}],
                [{r:3, c:0, v:1}, {r:3, c:1, v:0}, {r:3, c:2, v:0}, {r:3, c:3, v:0}, {r:3, c:4, v:0}, {r:3, c:5, v:0}, {r:3, c:6, v:0}, {r:3, c:7, v:1}],
                [{r:4, c:0, v:1}, {r:4, c:1, v:0}, {r:4, c:2, v:0}, {r:4, c:3, v:0}, {r:4, c:4, v:0}, {r:4, c:5, v:0}, {r:4, c:6, v:0}, {r:4, c:7, v:1}]
            ];

            $scope.volume = "";

        $scope.cellClick = function(row, col) {
            for (var i = 0; i < $scope.rows.length; i++) {
                if (i >= row) {
                    $scope.rows[i][col].v = 1;
                } else {
                    $scope.rows[i][col].v = 0;
                }
            }
        };

        $scope.cellDblClick = function(row, col) {
            for (var i = 0; i < $scope.rows.length; i++) {
                $scope.rows[i][col].v = 0;
            }
        };

        $scope.calculateVolume = function() {
            var hills = { hills:[] };

            for (var j = 0; j < $scope.rows[0].length; j++) {
                var sum = 0;
                for (var i = 0; i < $scope.rows.length; i++) {
                    sum += $scope.rows[i][j].v;
                }
                hills.hills.push(sum);
            }

            $http.post($window.contextPath + '/rest/volume', hills).
                            success(function (data) {
                                $scope.volume = data.volume;
                            }).error(function(){
                                console.log('Error: ' + data);
                             });
        };

    }]);

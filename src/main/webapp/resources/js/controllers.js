angular.module('app', [])
    .service('AtmSharingService', [function () {
        var atmList = [];

        return {
            getAtmList: function () {
                return atmList;
            },
            setAtmList: function (value) {
                atmList = value;
            }
        };
    }])
    .service('AtmZoomService', [function () {
        var map = {};

        return {
            zoomTo: function (lat, lng) {
                map.setCenter(new google.maps.LatLng(lat, lng));
                map.setZoom(16);
            },
            setMap: function (value) {
                map = value;
            }
        };
    }])
    .controller('AtmController', ['$scope', '$http', '$window', 'AtmSharingService', 'AtmZoomService',
        function ($scope, $http, $window, AtmSharingService, AtmZoomService) {
            $scope.city = "";
            $scope.atms = [];

            $scope.sortType = 'city';
            $scope.sortReverse = false;
            $scope.searchField = '';

            $scope.showCloser = function (lat, lon) {
                AtmZoomService.zoomTo(lat, lon);
            };

            $scope.searchAtms = function () {
                $scope.atms = [];
                $http.get($window.contextPath + '/atms/' + $scope.city).
                    success(function (data) {
                        AtmSharingService.setAtmList(data);
                        angular.forEach(data, function (item) {
                            $scope.atms.push({
                                city: item.city,
                                street: item.street,
                                houseNumber: item.houseNumber,
                                postalCode: item.postalCode,
                                geoLocation: item.geoLocation
                            });
                        });
                    }).error(function () {
                        console.log('Error: ' + data);
                    });
            }
        }])
    .controller('MapController', ['$scope', 'AtmSharingService', 'AtmZoomService',
        function ($scope, AtmSharingService, AtmZoomService) {

            $scope.atms = AtmSharingService.getAtmList();

            var mapOptions = {
                zoom: 7,
                center: new google.maps.LatLng(52.3167, 5.5500),
                mapTypeId: google.maps.MapTypeId.ROADMAP
            };

            $scope.map = new google.maps.Map(document.getElementById('googleMap'), mapOptions);

            AtmZoomService.setMap($scope.map);

            $scope.$watch(function () {
                    return AtmSharingService.getAtmList();
                },
                function (value) {
                    $scope.atms = value;

                    clearMarkers();

                    for (i = 0; i < $scope.atms.length; i++) {
                        createMarker($scope.atms[i]);
                    }

                    $scope.map.setCenter(new google.maps.LatLng(52.3167, 5.5500));
                    $scope.map.setZoom(7);
                }
            );

            $scope.markers = [];

            var clearMarkers = function () {
                for (i = 0; i < $scope.markers.length; i++) {
                    $scope.markers[i].setMap(null);
                }
                $scope.markers = [];
            };

            var infoWindow = new google.maps.InfoWindow();

            var icon = {
                url: "marker.png",
                scaledSize: new google.maps.Size(50, 50),
                origin: new google.maps.Point(0, 0),
                anchor: new google.maps.Point(25, 50)
            };

            var createMarker = function (info) {
                var marker = new google.maps.Marker({
                    map: $scope.map,
                    position: new google.maps.LatLng(info.geoLocation.latitude, info.geoLocation.longitude),
                    icon: icon
                });
                marker.content = '<div class="infoWindowContent">' + info.street + " " + info.houseNumber + '</div>';

                google.maps.event.addListener(marker, 'click', function () {
                    infoWindow.setContent('<h3>' + info.city + '</h3>' + marker.content);
                    infoWindow.open($scope.map, marker);
                });

                $scope.markers.push(marker);
            };

            $scope.openInfoWindow = function (e, selectedMarker) {
                e.preventDefault();
                google.maps.event.trigger(selectedMarker, 'click');
            }

        }]);
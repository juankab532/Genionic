webpackJsonp([3],{

/***/ 278:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "PruebaPageModule", function() { return PruebaPageModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(30);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__prueba__ = __webpack_require__(287);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};



var PruebaPageModule = (function () {
    function PruebaPageModule() {
    }
    return PruebaPageModule;
}());
PruebaPageModule = __decorate([
    __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["a" /* NgModule */])({
        declarations: [
            __WEBPACK_IMPORTED_MODULE_2__prueba__["a" /* PruebaPage */],
        ],
        imports: [
            __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["d" /* IonicPageModule */].forChild(__WEBPACK_IMPORTED_MODULE_2__prueba__["a" /* PruebaPage */]),
        ],
        exports: [
            __WEBPACK_IMPORTED_MODULE_2__prueba__["a" /* PruebaPage */]
        ]
    })
], PruebaPageModule);

//# sourceMappingURL=prueba.module.js.map

/***/ }),

/***/ 287:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return PruebaPage; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(30);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


/**
 * Generated class for the PruebaPage page.
 *
 * See http://ionicframework.com/docs/components/#navigation for more info
 * on Ionic pages and navigation.
 */
var PruebaPage = (function () {
    function PruebaPage(navCtrl, navParams) {
        this.navCtrl = navCtrl;
        this.navParams = navParams;
    }
    PruebaPage.prototype.ionViewDidLoad = function () {
        console.log('ionViewDidLoad PruebaPage');
    };
    return PruebaPage;
}());
PruebaPage = __decorate([
    __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_1_ionic_angular__["e" /* IonicPage */])(),
    __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_6" /* Component */])({
        selector: 'page-prueba',template:/*ion-inline-start:"/home/juan/ProyectoGrado/runtime-EclipseISML/AppIonic/src/Genionic/src/pages/prueba/prueba.html"*/'<!--\n  Generated template for the PruebaPage page.\n\n  See http://ionicframework.com/docs/components/#navigation for more info on\n  Ionic pages and navigation.\n-->\n<ion-header>\n	 <ion-navbar color="primary">\n	    <button ion-icon menuToggle>\n	      <ion-icon name="menu"></ion-icon>\n	    </button>\n	    <ion-title>Perfiles</ion-title>\n	 </ion-navbar>\n</ion-header>\n<ion-content padding>\n	<ion-grid>\n			<ion-row>\n	  				    <ion-col><ion-label>Codigo</ion-label>\n	  				    </ion-col>\n	  				    <ion-col><ion-label>Nombre</ion-label>\n	  				    </ion-col>\n	  				    <ion-col><ion-label>Descripcion</ion-label>\n	  				    </ion-col>\n	  				    <ion-col><ion-label>Semestre</ion-label>\n	  				    </ion-col>\n	  				    <ion-col><ion-label>Estado</ion-label>\n	  				    </ion-col>\n	  				    <ion-col><ion-label>Facultad</ion-label>\n	  				    </ion-col>\n	  				    <ion-col><ion-label>Editar</ion-label>\n	  				    </ion-col>\n	  				    <ion-col><ion-label>Eliminar</ion-label>\n	  				    </ion-col>\n			</ion-row>\n			<ion-row ng-repeat="asignatura in listaAsignatura | startFrom:(currentPage -1) * pageSize | limitTo: pageSize">\n	\n	  						<ion-col><ion-label>asignatura.codigo</ion-label>\n	  						</ion-col>		 \n	  						<ion-col><ion-label>asignatura.nombre</ion-label>\n	  						</ion-col>		 \n	  						<ion-col><ion-label>asignatura.descripcion</ion-label>\n	  						</ion-col>		 \n	  						<ion-col><ion-label>asignatura.semestre</ion-label>\n	  						</ion-col>		 \n	  						<ion-col><ion-label>asignatura.estado</ion-label>\n	  						</ion-col>		 \n	  						<ion-col><ion-label>asignatura.facultad</ion-label>\n	  						</ion-col>		 \n	  						<ion-col><button ion-button>Editar</button>\n	  						</ion-col>\n	  						<ion-col><button ion-button>Eliminar</button>\n	  						</ion-col>\n			</ion-row>\n	</ion-grid>\n	<button ion-button>Crear Asignatura</button>\n</ion-content>'/*ion-inline-end:"/home/juan/ProyectoGrado/runtime-EclipseISML/AppIonic/src/Genionic/src/pages/prueba/prueba.html"*/,
    }),
    __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1_ionic_angular__["f" /* NavController */], __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["g" /* NavParams */]])
], PruebaPage);

//# sourceMappingURL=prueba.js.map

/***/ })

});
//# sourceMappingURL=3.main.js.map
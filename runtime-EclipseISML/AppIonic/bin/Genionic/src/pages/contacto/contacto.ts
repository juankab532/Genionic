import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';

/**
 * Generated class for the ContactoPage page.
 *
 * See http://ionicframework.com/docs/components/#navigation for more info
 * on Ionic pages and navigation.
 */
@IonicPage()
@Component({
  selector: 'page-contacto',
  templateUrl: 'contacto.html',
})
export class ContactoPage {
  public items:any;

  constructor(public navCtrl: NavController, public navParams: NavParams) {
    this.items = [
  		{title: 'item1',id: '1'},
  		{title: 'item2',id: '2'},
  		{title: 'item3',id: '3'},
  		{title: 'item4',id: '4'},
  		{title: 'item5',id: '5'},
  		{title: 'item6',id: '6'}
  	];
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad ContactoPage');
  }

  hacerSubmit(){
    
  }
  

}

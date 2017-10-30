package co.edu.javeriana.generator.genionic.templates;

import co.edu.javeriana.generator.genionic.templates.ExtraGenionic;
import co.edu.javeriana.isml.generator.common.SimpleTemplate;
import co.edu.javeriana.isml.isml.Controller;
import co.edu.javeriana.isml.isml.Page;
import co.edu.javeriana.isml.isml.ViewInstance;
import co.edu.javeriana.isml.isml.ViewStatement;
import co.edu.javeriana.isml.scoping.IsmlModelNavigation;
import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class ComponentTemplate extends SimpleTemplate<List<Controller>> {
  @Inject
  @Extension
  private IQualifiedNameProvider _iQualifiedNameProvider;
  
  @Inject
  @Extension
  private IsmlModelNavigation _ismlModelNavigation;
  
  @Inject
  @Extension
  private ExtraGenionic _extraGenionic;
  
  private Set<Page> relatedPages = new LinkedHashSet<Page>();
  
  private List<String> elementsMenu = new ArrayList<String>();
  
  private List<String> pages = new ArrayList<String>();
  
  @Override
  protected CharSequence template(final List<Controller> e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import { Component, ViewChild } from \'@angular/core\';");
    _builder.newLine();
    _builder.append("import { Platform, Nav } from \'ionic-angular\';");
    _builder.newLine();
    _builder.append("import { StatusBar } from \'@ionic-native/status-bar\';");
    _builder.newLine();
    _builder.append("import { SplashScreen } from \'@ionic-native/splash-screen\';");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import { InicioPage } from \'../pages/inicio/inicio\';");
    _builder.newLine();
    _builder.newLine();
    {
      for(final String ctrl : this.pages) {
        _builder.append("import { ");
        String _firstUpper = StringExtensions.toFirstUpper(ctrl.toLowerCase());
        _builder.append(_firstUpper);
        _builder.append("Page } from \'../pages/");
        String _lowerCase = ctrl.toLowerCase();
        int _length = ctrl.length();
        int _minus = (_length - 1);
        String _substring = _lowerCase.substring(0, _minus);
        _builder.append(_substring);
        _builder.append("/");
        String _lowerCase_1 = ctrl.toLowerCase();
        _builder.append(_lowerCase_1);
        _builder.append("\';");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("@Component({");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("templateUrl: \'app.html\'");
    _builder.newLine();
    _builder.append("})");
    _builder.newLine();
    _builder.append("export class MyApp {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("@ViewChild(\'NAV\') nav: Nav;");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("public rootPage:any;");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("public pages:Array<{titulo:string,component:any,icon:string}>;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("  ");
    _builder.append("constructor(platform: Platform, statusBar: StatusBar, splashScreen: SplashScreen) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("this.rootPage=InicioPage;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("this.pages=[");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("{titulo:\'Inicio\',         component:InicioPage        ,icon:\'home\'},");
    _builder.newLine();
    {
      for(final String itemMenu : this.elementsMenu) {
        _builder.append(" \t\t\t  ");
        String _string = itemMenu.toString();
        _builder.append(_string, " \t\t\t  ");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("    ");
    _builder.append("];");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("platform.ready().then(() => {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("// Okay, so the platform is ready and our plugins are available.");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("// Here you can do any higher level native things you might need.");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("statusBar.styleDefault();");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("splashScreen.hide(); ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("});");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("  ");
    _builder.append("goToPage(page){");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("this.nav.setRoot(page);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  @Override
  public void preprocess(final List<Controller> c) {
    for (final Controller ctr : c) {
      EList<Page> _controlledPages = this._ismlModelNavigation.getControlledPages(ctr);
      for (final Page p : _controlledPages) {
        boolean _isHasBody = p.isHasBody();
        if (_isHasBody) {
          this.widgetTemplate(p.getBody());
        }
      }
    }
  }
  
  /**
   * Método para obtener las partes de cada componente de tipo block
   */
  public void widgetTemplate(final EList<ViewStatement> partBlock) {
    boolean _notEquals = (!Objects.equal(partBlock, null));
    if (_notEquals) {
      for (final ViewStatement part : partBlock) {
        if ((part instanceof ViewInstance)) {
          boolean _equalsIgnoreCase = this._ismlModelNavigation.getTypeSpecificationString(this._ismlModelNavigation.getTypeSpecification(((ViewInstance)part).getType())).equalsIgnoreCase("ExtendedMenu");
          if (_equalsIgnoreCase) {
            Controller c = this._ismlModelNavigation.getContainerController(((ViewInstance)part).getParameters().get(0));
            this.pages.add(c.getName());
            CharSequence _value = this._extraGenionic.getValue(((ViewInstance)part).getParameters().get(0));
            String _plus = ("{titulo:" + _value);
            String _plus_1 = (_plus + ",component:");
            String _firstUpper = StringExtensions.toFirstUpper(c.getName().toLowerCase());
            String _plus_2 = (_plus_1 + _firstUpper);
            String _plus_3 = (_plus_2 + "Page,icon:");
            CharSequence _value_1 = this._extraGenionic.getValue(((ViewInstance)part).getParameters().get(1));
            String _plus_4 = (_plus_3 + _value_1);
            String _plus_5 = (_plus_4 + "},");
            this.elementsMenu.add(_plus_5);
          }
        }
      }
    }
  }
}

import { AppPage } from './app.po';
import { browser,by,element, protractor } from 'protractor';
import { build$ } from 'protractor/built/element';

describe('workspace-project App', () => {
  let page: AppPage;

 
  beforeEach(() => {
    page = new AppPage();

  });
  it('should display title', () => {
    page.navigateTo();
    //browser.sleep(5000);
    expect(browser.getTitle()).toEqual('MovieCruiserUi');
  });

  it('should be redirect to /login route on opening the application',()=>{

    expect(browser.getCurrentUrl()).toContain('/login')
  });

  it('should be redirect to /register route',()=>{
    browser.element(by.css('.register-button')).click()
    expect(browser.getCurrentUrl()).toContain('/register')
  });

  it('should be able to register user',()=>{
    browser.element(by.id('firstName')).sendKeys('testabcd')
    browser.element(by.id('lastName')).sendKeys('testabcd')
    browser.element(by.id('userid')).sendKeys('testabcd')
    browser.element(by.id('password')).sendKeys('testabcd')
    browser.element(by.css('.register-user')).click()
    //browser.sleep(30000);
    expect(browser.getCurrentUrl()).toContain('/login')
  });

  it('should be able to login and navigate to popular movies',()=>{
    
    browser.element(by.id('userid')).sendKeys('testabcd')
    browser.element(by.id('password')).sendKeys('testabcd')
    browser.element(by.css('.login-user')).click()
    browser.sleep(5000);
    expect(browser.getCurrentUrl()).toContain('/movies/popular')
  });
  it('should be able to search movies',()=>{
    browser.element(by.css('.search-button')).click()
    expect(browser.getCurrentUrl()).toContain('/movies/search')
    browser.element(by.id('search-button-input')).sendKeys('Super')
    browser.element(by.id('search-button-input')).sendKeys(protractor.Key.ENTER)

    const searchItems =element.all(by.css('.movieTitle'))
    expect(searchItems.count()).toBe(20)
    for(let i=0;i<1;i+=1){
      expect(searchItems.get(i).getText()).toContain
    }
  });

  it('should be able to add movies to watchlist',async()=>{
    browser.driver.manage().window().maximize()
    browser.driver.sleep(1000);
    const searchItems=element.all(by.css('.movie-thumbnail'));
    expect(searchItems.count()).toBe(20)
    searchItems.get(0).click()
    browser.element(by.css('.addButton')).click()
  });
  
});

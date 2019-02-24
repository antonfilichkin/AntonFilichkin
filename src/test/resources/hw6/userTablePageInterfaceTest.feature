Feature: User Table Page Test

  Test sequence to assert User Table page interface functioning as expected.

  Scenario: User Table Page test
    Given I am on "HOME_PAGE"
    And I login as user "Piter Chailovskii"

    When I click on "SERVICE" subcategory in the header
    And I click on "USER_TABLE" button in Service dropdown
    Then "USER_TABLE_PAGE" is opened
    And 6 "NUMBERS" are displayed on Users Table on User Table Page
    And 6 "DROPDOWNS" are displayed on Users Table on User Table Page
    And 6 "USER_NAMES" are displayed on Users Table on User Table Page
    And 6 "DESCRIPTION_IMAGES" are displayed on Users Table on User Table Page
    And 6 "DESCRIPTION_TEXTS" under images are displayed on Users Table on User Table Page
    And 6 "CHECKBOXES" are displayed on Users Table on User Table Page
    And User table contains following values:
      | Number | User             | Desciption                       |
      | 1      | Roman            | Wolverine                        |
      | 2      | Sergey Ivan      | Spider Man                       |
      | 3      | Vladzimir        | Punisher                         |
      | 4      | Helen Bennett    | Captain America some description |
      | 5      | Yoshi Tannamuri  | Cyclope some description         |
      | 6      | Giovanni Rovelli | Hulk some description            |

    When I select 'vip' checkbox for "SERGEY_IVAN"
    Then 1 log row has "Vip: condition changed to true" text in log section

    When I click on dropdown in column Type for user "ROMAN"
    Then "ROMAN"s droplist contains values
      | Admin   |
      | User    |
      | Manager |

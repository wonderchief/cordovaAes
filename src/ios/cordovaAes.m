//
//  cordovaAes.m
//  好知音
//
//  Created by zoe on 16/1/22.
//
//

#import "cordovaAes.h"
#import "AES128Util.h"

@interface cordovaAes ()

@end

@implementation cordovaAes

- (void)encrypto:(CDVInvokedUrlCommand *)command
{

    NSString* key = [command.arguments objectAtIndex:0];
    NSString* text = [command.arguments objectAtIndex:1];
    self.callbackId = command.callbackId;
    NSLog(@"token:%@",self.callbackId);
    NSString *ret = [AES128Util AES128Encrypt:text key:key];
    CDVPluginResult *pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsDictionary:ret];
    [self.commandDelegate sendPluginResult:pluginResult callbackId:self.callbackId];
    
}
- (void)decrypto:(CDVInvokedUrlCommand *)command
{
    
    NSString* key = [command.arguments objectAtIndex:0];
    NSString* text = [command.arguments objectAtIndex:1];
    NSString *ret = [AES128Util AES128Decrypt:text key:key];
    self.callbackId = command.callbackId;
    NSLog(@"token:%@",self.callbackId);
    CDVPluginResult *pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsDictionary:ret];
    [self.commandDelegate sendPluginResult:pluginResult callbackId:self.callbackId];
    
}
@end

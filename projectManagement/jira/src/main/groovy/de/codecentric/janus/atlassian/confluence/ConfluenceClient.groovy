package de.codecentric.janus.atlassian.confluence

import com.atlassian.confluence.rpc.soap.beans.RemoteSpace
import com.atlassian.confluence.rpc.soap.beans.RemoteUser

/**
 * @author Ben Ripkens <bripkens.dev@gmail.com>
 */
class ConfluenceClient implements ConfluenceSoapClient {
    final ConfluenceSession session

    ConfluenceClient(ConfluenceSession session) {
        this.session = session
    }

    @Override
    RemoteSpace addSpace(RemoteSpace space) {
        return session.confluenceSoapClient.addSpace(space)
    }

    @Override
    void deleteSpace(String key) {
        session.confluenceSoapClient.deleteSpace(key)
    }

    @Override
    void createUser(RemoteUser user, String password) {
        session.confluenceSoapClient.createUser(user, password)
    }

    @Override
    RemoteUser getUser(String username) {
        return session.confluenceSoapClient.getUser(username)
    }

    @Override
    void deleteUser(String username) {
        session.confluenceSoapClient.deleteUser(username)
    }

    @Override
    RemoteSpace getSpace(String key) {
        return session.confluenceSoapClient.getSpace(key)
    }

    @Override
    void removeAnonymousPermissionFromSpace(SpacePermission permission,
                                            String spaceKey) {
        session.confluenceSoapClient
                .removeAnonymousPermissionFromSpace(permission, spaceKey)
    }

    @Override
    void removeAllAnonymousPermissionsFromSpace(String spaceKey) {
        session.confluenceSoapClient
                .removeAllAnonymousPermissionsFromSpace(spaceKey)
    }
}